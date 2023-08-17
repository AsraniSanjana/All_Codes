import random

list = []

def item_create():
    list_item = [random.randint(1, 50), random.randint(1, 102), random.randint(1, 50), random.randint(1, 30),
                 random.randint(1, 210), random.randint(1, 1000)]
    if list_item in list:
        item_create()
    return list_item

for i in range(1, 100):
    list.append(item_create())
for i in list:
    print(
        f'insert into SVN_SALES_ANALYSIS_FT(time_id, prod_id, cust_id, store_id,staff_id,order_id,'
        f' annual_sales,summer_sales,category_wise_sales ) values ({i[0]}, {i[1]}, {i[2]}, {i[3]}, {i[4]}, {i[5]}, '
        f'{random.randint(1, 10000)}, {random.randint(1, 2000)}, {random.randint(1, 100)})')
