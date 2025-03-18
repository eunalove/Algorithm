select rr.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, round(avg(REVIEW_SCORE), 2) as SCORE
from REST_INFO as ri
join REST_REVIEW as rr
on ri.rest_id= rr.rest_id
where ADDRESS like '서울%'
group by rr.REST_ID
order by SCORE desc, FAVORITES desc