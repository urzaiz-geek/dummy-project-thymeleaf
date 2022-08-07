package com.urzaizcoding.dummyspringthymeleaf.utils.ui;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.urzaizcoding.dummyspringthymeleaf.utils.ui.PageItem.ItemType;

class PagingTest {

	@ParameterizedTest
	@MethodSource("provideArgsForPageItems")
	public void shouldEnsureThatPaginationIsWellSplitedForFirstPage(int totalPages,int currentPage, PageItem[] expected) throws Exception {
		//Given
		Paging underTest = new Paging(totalPages, 5,currentPage);
		
		//When
		
		PageItem frame [] = underTest.getItems();
		
		//Then
		
		assertThat(frame).contains(expected);
		
	}
	
	private static Stream<Arguments> provideArgsForPageItems() {
		return Stream.of(
				Arguments.of(10,1,new PageItem[] {
						new PageItem(1,ItemType.NUMERAL),
						new PageItem(2,ItemType.NUMERAL),
						new PageItem(3,ItemType.NUMERAL),
						new PageItem(4,ItemType.NUMERAL),
						new PageItem(0,ItemType.DOTS)
				}),
				Arguments.of(10,2,new PageItem[] {
						new PageItem(1,ItemType.NUMERAL),
						new PageItem(2,ItemType.NUMERAL),
						new PageItem(4,ItemType.NUMERAL),
						new PageItem(4,ItemType.NUMERAL),
						new PageItem(0,ItemType.DOTS)
				}),Arguments.of(10,3,new PageItem[] {
						new PageItem(1,ItemType.NUMERAL),
						new PageItem(2,ItemType.NUMERAL),
						new PageItem(3,ItemType.NUMERAL),
						new PageItem(4,ItemType.NUMERAL),
						new PageItem(0,ItemType.DOTS)
				}),Arguments.of(10,6,new PageItem[] {
						new PageItem(5,ItemType.NUMERAL),
						new PageItem(6,ItemType.NUMERAL),
						new PageItem(7,ItemType.NUMERAL),
						new PageItem(8,ItemType.NUMERAL),
						new PageItem(0,ItemType.DOTS)
				}),
				Arguments.of(10,9,new PageItem[] {
						new PageItem(0,ItemType.DOTS),
						new PageItem(9,ItemType.NUMERAL),
						new PageItem(10,ItemType.NUMERAL),
				}),
				Arguments.of(5,1,new PageItem[] {
						new PageItem(1,ItemType.NUMERAL),
						new PageItem(2,ItemType.NUMERAL),
						new PageItem(3,ItemType.NUMERAL),
						new PageItem(4,ItemType.NUMERAL),
				}),
				Arguments.of(5,5,new PageItem[] {
						new PageItem(0,ItemType.DOTS),
						new PageItem(5,ItemType.NUMERAL),
				}),
				Arguments.of(3,1,new PageItem[] {
						new PageItem(1,ItemType.NUMERAL),
						new PageItem(2,ItemType.NUMERAL),
						new PageItem(3,ItemType.NUMERAL),
				})
				);
	}

}
