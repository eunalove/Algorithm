select CAR_ID, round(sum(datediff(END_DATE, START_DATE) +1) / count(*) , 1) as AVERAGE_DURATION 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
having round(sum(datediff(END_DATE, START_DATE) +1) / count(*) , 1) >= 7
order by AVERAGE_DURATION desc, CAR_ID desc