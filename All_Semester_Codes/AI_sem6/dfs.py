
graph1 = {
    
    '1' :['2','3','4'],
    '2':['5','6'],
    '3':['7'],
    '4':['8','9'],
    '5':[],
    '6':['10','11'],
    '7':['12','13'],
    '8':[],
    '9':[],
    '10':[],
    '11':[],
    '12':[],
    '13':[]
}

visited = []

def dfs(graph,node):
    stack = [node]
    global visited
    while stack:
        s = stack.pop()
    if node not in visited:
        visited.append(node)   
    for neighbour in graph[s]:
            if neighbour not in visited:
                stack.append(neighbour)
    print("pushing",stack, "onto stack and popping & addding ",s, "to  visited list")	
    print("visited list", visited)
    print("------------------------------------------")
    for n in graph[node]:
            dfs(graph,n)


dfs(graph1,'1')
print("the dfs traversal is : ",visited)