import heapq
from beautifultable import BeautifulTable
class priorityQueue:
    def __init__(self):
        self.cities = []
    def push(self, city, cost):
        heapq.heappush(self.cities, (cost, city))
    def pop(self):
        return heapq.heappop(self.cities)[1]
    def isEmpty(self):
        if (self.cities == []):
            return True
        else:
            return False
    def check(self):
        print(self.cities)

class ctNode:
    def __init__(self, city, distance):
        self.city = str(city)
        self.distance = str(distance)

romania = {}

def makedict():
    file = open("G_romania.txt", 'r')
    for string in file:
        line = string.split(',')
        ct1 = line[0]
        ct2 = line[1]
        dist = int(line[2])
        romania.setdefault(ct1, []).append(ctNode(ct2, dist))
        romania.setdefault(ct2, []).append(ctNode(ct1, dist))
        
def makehuristikdict():
    h = {}
    with open("H_romania_sld.txt", 'r') as file:
        for line in file:
            line = line.strip().split(",")
            node = line[0].strip()
            sld = int(line[1].strip())
            h[node] = sld
    return h

def heuristic(node, values):
    return values[node]

def astar(start, end):
    path = {}
    distance = {}
    table = BeautifulTable()
    q = priorityQueue()
    h = makehuristikdict()
    q.push(start, 0)
    distance[start] = 0
    path[start] = None
    expandedList = []
    while (q.isEmpty() == False):
        current = q.pop()
        expandedList.append(current)
        if (current == end):
            break
        for new in romania[current]:
            g_cost = distance[current] + int(new.distance)
            if (new.city not in distance or g_cost < distance[new.city]):
                
                distance[new.city] = g_cost
                f_cost = g_cost + heuristic(new.city, h)
                print(f'{current:18} {new.city:18} {g_cost:18}  |  {heuristic(new.city,h):18}  |  {f_cost:18}')
               
                q.push(new.city, f_cost)
                path[new.city] = current
            
    printoutput(start, end, path, distance, expandedList)
    



def printoutput(start, end, path, distance, expandedlist):
    finalpath = []
    i = end
    while (path.get(i) != None):
        finalpath.append(i)
        i = path[i]
    finalpath.append(start)
    finalpath.reverse()
    print("A-star Agorithm for Romania Map")
    print("\tArad => Bucharest")
    print("=======================================================")
    print("List of Cities that are Expanded : " + str(expandedlist))
    print("Total Number of Cities that are Expanded : " + str(len(expandedlist)))
    print("=======================================================")
    print("Cities in Final path : " + str(finalpath))
    print("Total Number of cities in final path are : " + str(len(finalpath)))
    print("Total Cost : " + str(distance[end]))

def main():
    src = "Arad"
    dst = "Bucharest"
    makedict()
    print(f'{"from":18} {"to":18}     \t\t\t{"g(n)  |":18}   \t{"h(n) |":18}  \t{"f(n)":18}')
    
    print("---------------------------------------------------------------------------------------------------------")
    astar(src, dst)
    
    

if __name__ == "__main__" :
    main()