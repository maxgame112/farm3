package healthcares.spring.myapp;

public class PageCount {

	public Page getPage(int pagePresent,int pageLast){
		Page page =new Page();
		if(pageLast > 5 ){
			
			if(pagePresent ==1 ){
				page.setPageFirst(0);
				page.setPageFirst1(0);
			}else if(pagePresent <=3){
				page.setPageFirst(0);
				page.setPageFirst1(pagePresent-1);
			}else if(pagePresent > 3){
				page.setPageFirst(1);
				page.setPageFirst1(pagePresent-1);
			}
			
			
			if(pagePresent ==1 ){
				page.setPagePrevious(0);
				page.setPagePrevious1(0);
			}else if(pagePresent == 2){
				page.setPagePrevious(0);
				page.setPagePrevious1(pagePresent-1);
			}else if(pagePresent > 2){
				page.setPagePrevious(pagePresent-2);
				page.setPagePrevious1(pagePresent-1);
			}
			
			page.setPagePresent(pagePresent);
			
			if(pageLast == pagePresent){
				page.setPageNext(0);
				page.setPageNext1(0);
			}else if((pageLast-1) == pagePresent){
				page.setPageNext(pagePresent+1);
				page.setPageNext1(0);
			}else if((pageLast-1) > pagePresent){
				page.setPageNext(pagePresent+1);
				page.setPageNext1(pagePresent+2);
			}
			
			if(pageLast == pagePresent){
				page.setPageLast(0);
				page.setPageLast1(0);
			}else if((pageLast-2) <= pagePresent){
				page.setPageLast(pagePresent+1);
				page.setPageLast1(0);
			}else if((pageLast-2) > pagePresent){
				page.setPageLast(pagePresent+1);
				page.setPageLast1(pageLast);
			}
			
			page.setPage(pagePresent);
			page.setPageFinal(pageLast);
		}else if(pageLast > 1 ){
			page.setPageFirst(0);
			page.setPageFirst1(0);
			if(pageLast>=1){
				page.setPagePrevious(1);
			}else{
				page.setPagePrevious(0);
			}
			
			if(pageLast>=2){
				page.setPagePrevious1(2);
			}else{
				page.setPagePrevious1(0);
			}
			if(pageLast>=3){
				page.setPagePresent(3);
			}else{
				page.setPagePresent(0);
			}
			
			if(pageLast>=4){
				page.setPageNext(4);;
			}else{
				page.setPageNext(0);
			}
			
			if(pageLast>=5){
				page.setPageNext1(5);;
			}else{
				page.setPageNext1(0);
			}
			page.setPageLast(0);
			page.setPageLast1(0);
			page.setPage(pagePresent);
			page.setPageFinal(pageLast);
		}else{
			page.setPageFirst(0);
			page.setPageFirst1(0);
			page.setPagePrevious(0);
			page.setPagePrevious1(0);
			page.setPagePresent(0);
			page.setPageNext(0);;
			page.setPageNext1(0);;
			page.setPageLast(0);
			page.setPageLast1(0);
			page.setPage(0);
			page.setPageFinal(0);
		}
		
		return page;
	}
}
