package com.urzaizcoding.dummyspringthymeleaf.utils.ui;

import com.urzaizcoding.dummyspringthymeleaf.utils.ui.PageItem.ItemType;

public class Paging {
	private final int totalPages;
	private int visibleItems;
	private int currentPage;
	private final int lastPage;
	private PageItem[] items;

	public Paging(int totalPages, int visibleItems, int currentPage) throws IllegalArgumentException {
		if (totalPages < 0) {
			throw new IllegalArgumentException("totalPages cannot be negative");
		}

		this.totalPages = totalPages;
		this.lastPage = totalPages - 1;
		setVisibleItems(visibleItems);
		if (currentPage <= totalPages && currentPage >= 1) {
			this.currentPage = currentPage;
		} else {
			throw new IllegalArgumentException("invalid value for currentPage");
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

	public int getTotalPages() {
		return this.totalPages;
	}

	// pages start at 0
	public int getCurrentPage() {
		return currentPage - 1;
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

		int pageIncrementor = 0;
		if (totalPages < visibleItems) {
			items = new PageItem[totalPages];
			for (int i = 0; i < totalPages; i++) {
				items[i] = new PageItem(pageIncrementor + min, ItemType.NUMERAL,
						currentPage == (pageIncrementor + min));
				pageIncrementor++;
			}
		} else {
			if (limit > totalPages)
				limit = totalPages;
			items = new PageItem[limit - min + 2];

			// filling it

			int init = currentFrame == frames ? 1 : 0;
			int end = currentFrame == frames ? items.length : items.length - 1;
			for (int i = init; i < end; i++) {
				items[i] = new PageItem(pageIncrementor + min, ItemType.NUMERAL,
						currentPage == (pageIncrementor + min));
				pageIncrementor++;
			}

			// we have to append dots
			if (currentFrame == frames) {
				items[0] = new PageItem(0, ItemType.DOTS, false);
			} else { // we have to prepend dots
				items[end] = new PageItem(0, ItemType.DOTS, false);
			}

		}

		return items;
	}

	public boolean canNext() {
		return currentPage < totalPages;
	}

	public boolean canPrev() {
		return currentPage - 1 > 0;
	}

	public int firstPage() {
		return 0;
	}

	public int lastPage() {
		return lastPage;
	}
}
