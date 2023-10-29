#문제를 대충 읽는 습관을 고쳐야한다
#진짜로... 예시에서도 user_id가 겹치는 상황이 있는데 그냥 count(*)을 해버림ㅠㅜ

select year(SALES_DATE) as YEAR , month(SALES_DATE) as MONTH, GENDER, count(distinct o.USER_ID) as USERS
from USER_INFO u join ONLINE_SALE o
on u.USER_ID= o.USER_ID
where GENDER is not null
group by year(SALES_DATE), month(SALES_DATE), GENDER
order by year(SALES_DATE), month(SALES_DATE), GENDER