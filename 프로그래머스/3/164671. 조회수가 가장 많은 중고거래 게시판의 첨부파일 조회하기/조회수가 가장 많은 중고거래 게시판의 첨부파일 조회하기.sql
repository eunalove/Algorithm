select concat("/home/grep/src/", board.BOARD_ID,"/", file.FILE_ID, file.FILE_NAME,file.FILE_EXT) as FILE_PATH
from USED_GOODS_BOARD board join USED_GOODS_FILE file
on board.BOARD_ID= file.BOARD_ID
where (board.VIEWS) = (select max(sub.VIEWS)
                   from USED_GOODS_BOARD sub)
order by file.FILE_ID desc