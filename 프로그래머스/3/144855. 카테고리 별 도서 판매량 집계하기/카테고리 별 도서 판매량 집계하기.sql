select category, sum(sales) as TOTAL_SALES
from BOOK_SALES join BOOK 
on BOOK_SALES.BOOK_ID= BOOK.BOOK_ID
where year(SALES_DATE) =2022
and month(SALES_DATE) =1
group by category
order by category