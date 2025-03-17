select D.ID,
    case
        when D.R >= 0.75 then 'CRITICAL'
        when D.R >= 0.5 then 'HIGH'
        when D.R >= 0.25 then 'MEDIUM'
        else 'LOW'
    end as COLONY_NAME
from (select ID, percent_rank() over (order by SIZE_OF_COLONY) as R 
      from ECOLI_DATA) as D
order by ID;