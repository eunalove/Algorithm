select distinct(car.CAR_ID)
from CAR_RENTAL_COMPANY_CAR as car inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY as his
on car.CAR_ID = his.CAR_ID 
where month(START_DATE) = 10
and car.CAR_TYPE= '세단'
order by car.CAR_ID desc;