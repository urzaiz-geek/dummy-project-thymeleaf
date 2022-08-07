package com.urzaizcoding.dummyspringthymeleaf.utils.ui;

import java.util.Objects;

public class PageItem {
	
	

	public enum ItemType {
		NUMERAL,DOTS
	}

	private final int pageNumber;
	private ItemType itemType;
	
	
	public PageItem(int pageNumber,ItemType itemType) {
		super();
		this.pageNumber = pageNumber;
		this.itemType = itemType;
	}
	
	
	
	public int getpageNumber() {
		return pageNumber;
	}
	


	public ItemType getItemType() {
		return itemType;
	}
	
	
	
	@Override
	public String toString() {
		return "PageItem [pageNumber=" + pageNumber + ", itemType=" + itemType + "]";
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
