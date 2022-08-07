package com.urzaizcoding.dummyspringthymeleaf.utils.ui;

import com.urzaizcoding.dummyspringthymeleaf.utils.ui.PageItem.ItemType;

public class Paging {
	private final int totalPages;
	private int visibleItems;
	private int currentPage;

	public Paging(int totalPages, int visibleItems, int currentPage) throws IllegalArgumentException {
		if (totalPages < 0) {
			throw new IllegalArgumentException("totalPages cannot be negative");
		}

		this.totalPages = totalPages;
		setVisibleItems(visibleItems);
		if (currentPage <= totalPages && currentPage >= 0) {
			this.currentPage = currentPage;
		}
	}

	public void setVisibleItems(int visibleItems) {
		if (visibleItems > 0) {
			if (visibleItems > 5) {
				this.visibleItems = 5;
			} else {
				this.visibleItems = visibleItems;
			}
		}
	}

	public PageItem[] getItems() {

		// find the number of frames

		int frames = (int) Math.ceil((double) totalPages / (visibleItems - 1));

		frames = frames == 0 ? 1 : frames;

		int min = 1;
		int limit = visibleItems - 1;
		int currentFrame = 1;
		for (int i = 1; i <= frames; i++) {
			if (currentPage <= limit) {
				break;
			}
			currentFrame++;
			min += visibleItems - 1;
			limit += visibleItems - 1;
		}

		PageItem[] returned = null;
		int pageIncrementor = 0;
		if (totalPages < visibleItems) {
			returned = new PageItem[totalPages];
			for (int i = 0; i < totalPages; i++) {
				returned[i] = new PageItem(pageIncrementor + min, ItemType.NUMERAL);
				pageIncrementor++;
			}
		} else {
			if (limit > totalPages)
				limit = totalPages;
			returned = new PageItem[limit - min + 2];

			// filling it

			int init = currentFrame == frames ? 1 : 0;
			int end = currentFrame == frames ? returned.length : returned.length - 1;
			for (int i = init; i < end; i++) {
				returned[i] = new PageItem(pageIncrementor + min, ItemType.NUMERAL);
				pageIncrementor++;
			}

			// we have to append dots
			if (currentFrame == frames) {
				returned[0] = new PageItem(0, ItemType.DOTS);
			} else { // we have to prepend dots
				returned[end] = new PageItem(0, ItemType.DOTS);
			}

		}

		return returned;
	}

	public boolean canNext() {
		return currentPage < totalPages;
	}

	public boolean canPrev() {
		return currentPage > 1;
	}

	public PageItem first() {
		return new PageItem(1, ItemType.NUMERAL);
	}

	public PageItem last() {
		return new PageItem(totalPages, ItemType.NUMERAL);
	}
}
