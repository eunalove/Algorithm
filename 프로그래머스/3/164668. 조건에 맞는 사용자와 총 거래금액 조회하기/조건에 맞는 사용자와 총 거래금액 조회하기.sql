SELECT USER_ID, NICKNAME, sum(PRICE) as TOTAL_SALES
from USED_GOODS_BOARD as board inner join USED_GOODS_USER as user
on board.WRITER_ID = user.USER_ID
where board.STATUS= 'DONE'
group by board.WRITER_ID
having sum(PRICE) >= 700000
order by TOTAL_SALES