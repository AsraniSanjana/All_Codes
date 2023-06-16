import sys
search_cost=0
parentChildN={
    1:[2,3,4],
    2:[5,6],
    3:[7],
    4:[8,9],
    5:[],
    6:[10,11],
    7:[12,13],
    8:[],
    9:[],
    10:[],
    11:[],
    12:[],
    13:[]
}
# goalsX={3,9,10}
goalsX={
    # 13, 
        7
        }
# goalsO={5,8,11}
# goalStatesXDepth={
#     3:1,
#     9:3,
#     10:3
# }
goalStatesXDepth={
#    13:4,
   7: 3
}
# 13 is at depth=4
frontier=[1]
visited=[]
parent={}
nodesAtLevel={
    0:{1},
    1: {2, 3, 4},
    2: {5, 6, 7, 8,9},
    3: {10, 11,12,13}
}
flag=False
limit=4
goals=[]
current=0
while current<=limit:
    if(len(frontier)==0):
        break
    node=frontier.pop(0)
    visited.append(node)
    for elem in parentChildN[node]:
        parent[elem]=node
        frontier.append(elem)
    print("frontier list", frontier)
    print("visited list", visited)
    print("------------------------------------------")
    for child in parentChildN[node]:
        if (child in goalsX):
           goalPaths=[child]
           if (goalStatesXDepth[child]<=limit):
               flag=True
               while True:
                   node=parent[child]
                   child=node
                   goalPaths.append(node)
                   if(child==1):
                       break
               goals.append(goalPaths)
            
           else:
               break
    flagVisited=True
    for n in nodesAtLevel[current]:
        if n not in visited:
            flagVisited=False
    if(flagVisited):
        current+=1
costArr=[]
for path in goals:
    costArr.append(len(path)-1)
minCost=sys.maxsize
index=-1
print("The possible paths")
for i in range(len(goals)):
    print(goals[i],costArr[i],sep="->")
    if(costArr[i]<minCost):
        index=i
        minCost=costArr[i]
print("Optimal path is:",goals[index],"with cost of: ", costArr[index])

