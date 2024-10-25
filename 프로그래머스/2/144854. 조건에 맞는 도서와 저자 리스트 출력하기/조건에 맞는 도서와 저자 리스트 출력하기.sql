select BOOK_ID, AUTHOR_NAME, substr(PUBLISHED_DATE,1) as PUBLISHED_DATE from book as b join author as a
on b.AUTHOR_ID = a.AUTHOR_ID
where CATEGORY = '경제'
order by PUBLISHED_DATE