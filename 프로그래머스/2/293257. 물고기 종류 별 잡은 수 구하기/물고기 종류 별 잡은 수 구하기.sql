select count(*) as FISH_COUNT, FISH_NAME
from FISH_INFO as finfo join FISH_NAME_INFO as fname
on finfo.fish_type = fname.fish_type
group by FISH_NAME
order by FISH_COUNT desc