function page_nav(frm,num,totalPage){
	if(num < 1){
		return;
	}
	if(num > totalPage){
		return;
	}
	frm.pageIndex.value = num;
	frm.submit();
}
