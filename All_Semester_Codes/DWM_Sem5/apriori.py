# data = [
#         ['T100',['I1','I2','I5']],
#         ['T200',['I2','I4']],
#         ['T300',['I2','I3']],
#         ['T400',['I1','I2','I4']],
#         ['T500',['I1','I3']],
#         ['T600',['I2','I3']],
#         ['T700',['I1','I3']],
#         ['T800',['I1','I2','I3','I5']],
#         ['T900',['I1','I2','I3']]
#         ]

# print(len(data)) no of transactions
# I1 : Bread , I2 : Cheese , I3 : Egg , I4 : Juice , I5 : Milk , I6 : Yogurt
# data=[
#         ['T1',['I1','I2','I3','I4']],
#         ['T2',['I1','I2','I4']],
#         ['T3',['I1','I5','I6']],
#         ['T4',['I1','I4','I5']],
#         ['T5',['I2','I4', 'I5']],
      
# ]
data=[
        ['T1',['bread','jelly','butter']],
        ['T2',['bread','butter']],
        ['T3',['bread','milk','butter']],
        ['T4',['coke','bread']],
        ['T5',['coke', 'milk']],
      
]

init = []
for i in data:
    for q in i[1]:
        if(q not in init):
            init.append(q)
init = sorted(init)
print(init)

sp = 0.3
s = int(sp*len(init))  # min support

from collections import Counter

c = Counter()
for i in init:
    for d in data:
        if(i in d[1]):
            c[i]+=1
print("C1:")
print("\nitemset\tfrequency  support")
for i in c:
    print(str([i])+": "+str(c[i])+"\t\t"+str(c[i]*100/len(data)))   # c[i] is frequency/count of an item
                                                                    # [i] is I1,I2...
print()
l = Counter()
for i in c:
    if(c[i] >= s):
        l[frozenset([i])]+=c[i]
print("L1:Itemsets that satisfies the min support threshold :")

for i in l:
    print(str(list(i))+": "+str(l[i]))
print()
pl = l
pos = 1
for count in range (2,1000):
    nc = set()
    temp = list(l)
    for i in range(0,len(temp)):
        for j in range(i+1,len(temp)):
            t = temp[i].union(temp[j])
            if(len(t) == count):
                nc.add(temp[i].union(temp[j]))
    nc = list(nc)
    c = Counter()
    for i in nc:
        c[i] = 0
        for q in data:
            temp = set(q[1])
            if(i.issubset(temp)):
                c[i]+=1
    print("C"+str(count)+":")
    print("\nitemset\tfrequency  support")
    for i in c:
        print(str(list(i))+": "+str(c[i])+"\t\t"+str(c[i]*100/len(data)))
    print()
    l = Counter()
    for i in c:
        if(c[i] >= s):
            l[i]+=c[i]
    print("L"+str(count)+":Itemsets that satisfies the min support threshold :")
    for i in l:
        print(str(list(i))+": "+str(l[i]))
    print()
    if(len(l) == 0):
        break
    pl = l
    pos = count
print("Result: ")
print("L"+str(pos)+":")
for i in pl:
    print(str(list(i))+": "+str(pl[i]))
print()

from itertools import combinations
for l in pl:
    c = [frozenset(q) for q in combinations(l,len(l)-1)]
    mmax = 0
    for a in c:
        b = l-a
        ab = l
        sab = 0
        sa = 0
        sb = 0
        for q in data:
            temp = set(q[1])
            if(a.issubset(temp)):
                sa+=1
            if(b.issubset(temp)):
                sb+=1
            if(ab.issubset(temp)):
                sab+=1
        temp = sab/sa*100
        if(temp > mmax):
            mmax = temp
        temp = sab/sb*100
        if(temp > mmax):
            mmax = temp
        print("confidence:")
        print(str(list(a))+" -> "+str(list(b))+" = "+str(sab/sa*100)+"%")
        print(str(list(b))+" -> "+str(list(a))+" = "+str(sab/sb*100)+"%")
    curr = 1
    print("choosing:", end=' ')
    for a in c:
        b = l-a
        ab = l
        sab = 0
        sa = 0
        sb = 0
        for q in data:
            temp = set(q[1])
            if(a.issubset(temp)):
                sa+=1
            if(b.issubset(temp)):
                sb+=1
            if(ab.issubset(temp)):
                sab+=1
        temp = sab/sa*100
        if(temp == mmax):
            print(curr, end = ' ')
        curr += 1
    print()