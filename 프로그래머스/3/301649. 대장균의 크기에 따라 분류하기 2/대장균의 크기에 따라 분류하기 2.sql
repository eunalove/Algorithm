select ID,
     case
         when sub.r <= 0.25 then 'CRITICAL'
         when sub.r <= 0.5 then 'HIGH'
         when sub.r<= 0.75 then 'MEDIUM'
         else 'LOW'
    end as COLONY_NAME
    from (select id, percent_rank() over(order by SIZE_OF_COLONY desc) as r
            from ECOLI_DATA) as sub
order by id