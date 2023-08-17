from operator import concat
import random

list = []

def item_create():
    list_item = ["T_"+str(random.randint(1, 50)),"P_"+str( random.randint(1, 105)), "C_"+str(random.randint(1, 500)), 
    "St_"+str(random.randint(1, 30)), "ON_"+str(random.randint(1, 1000))]
    # no of foreign keys jitne list items with their number of rows 
    if list_item in list:
        item_create()
    return list_item

for i in range(1, 100):
    # 100 records for fact table will be generated
    list.append(item_create())
for i in list:
    print(
        f'insert into SVN_SALES_ANALYSIS_FT(time_id, prod_id, cust_id, store_id,order_id,'
        f' unit_sales,weekly_prodcat_sales,yearly_prod_city_sales ) values (\'{i[0]}\', \'{i[1]}\', \'{i[2]}\', '
        f'\'{i[3]}\', \'{i[4]}\', \'{"$"+str(random.randint(1, 600))}\', \'{"$"+str(random.randint(1, 2000))}\', '
        f'\'{"$"+str(random.randint(1, 10000))}\');')

        # take all fk from the list and measures between the specified range.
