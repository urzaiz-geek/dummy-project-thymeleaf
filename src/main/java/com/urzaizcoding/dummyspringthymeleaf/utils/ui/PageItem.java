package com.urzaizcoding.dummyspringthymeleaf.utils.ui;

import java.util.Objects;

public class PageItem {

	public enum ItemType {
		NUMERAL, DOTS
	}

	private final int pageNumber;
	private ItemType itemType;
	private final boolean active;

	public PageItem(int pageNumber, ItemType itemType, boolean active) {
		super();
		this.pageNumber = pageNumber;
		this.itemType = itemType;
		this.active = active;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getPageIndex() {
		return pageNumber - 1;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public boolean isActive() {
		return active;
	}

	@Override
	public String toString() {
		return "PageItem [pageNumber=" + pageNumber + ", itemType=" + itemType + ", active=" + active + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemType, pageNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageItem other = (PageItem) obj;
		return itemType == other.itemType && pageNumber == other.pageNumber;
	}

}
