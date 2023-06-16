
from collections import deque
import queue
import heapq
from networkx.readwrite import edgelist
import numpy as np
import networkx as nx
import matplotlib.pyplot as plt
'''
simple case
given adjacent list and heuristic function, find the optimal path.
'''


class PriorityQueue(object):
    def __init__(self):
        self._queue = []        
        self._index = 0        
    
    def push(self, node):
        heapq.heappush(self._queue, (node.cost, self._index, node.name)) 
        self._index += 1
        
    def pop(self):
        return heapq.heappop(self._queue)[-1]    
    
    def is_empty(self):
        if len(self._queue) == 0:
            return True
        return False

    def have(self, node):
        q = [i[2] for i in self._queue]
        if node in q:
            return True
        return False
    
    def get_score(self, node):
        q = [i[2] for i in self._queue]
        return self._queue[q.index(node)][0]
    
    def change_score(self, node, cost):
        q = [i[2] for i in self._queue]
        idx = self._queue[q.index(node)][1]
        self._queue[q.index(node)] = (cost,idx,node)


class node(object):
    def __init__(self, name, cost):
        self.name = name
        self.cost = cost

    def __repr__(self):
        return f'node_name={self.name}, node_cost={self.cost}'


class bestFirst:
    def __init__(self,adjacent_list, heuristic_function,show_animation=True):
        self.adj = adjacent_list
        self.h = heuristic_function
        self.show_animation = show_animation
    
    def search(self,s,e):
        came_from = dict()

        explored = set([])
        frontier = PriorityQueue()
        n = node(s, self.h[s])
        frontier.push(n)
        if self.show_animation:
            self.init_graph(s,e)
        while True:
            if frontier.is_empty():
                print('failed')
                return None
            n = frontier.pop()
            if n == e:
                path = self.reconstruct_path(came_from, s, e)
                print('find path: ', path)
                if self.show_animation:
                    self.init_graph(s,e)
                    self.update_graph(path)
                    print(f'Find the optimal path: {path}')
                return self.reconstruct_path(came_from, s, e)
            explored.add(n)
            for neighbor, cost in self.adj[n]:
                total_cost = self.h[neighbor] #f=H
                if neighbor not in explored and frontier.have(neighbor) == False:
                    frontier.push(node(neighbor,total_cost))
                    came_from[neighbor] = n
                    if self.show_animation:
                        # cost or g(n) is always 0 in case of best first search : considers only h(n)
                        # greedy best first search considers only g(n)
                        print(f' for {neighbor}: F(n)=h(n)= {self.h[neighbor]} = {total_cost}')
                        
                elif frontier.have(neighbor):
                    if frontier.get_score(neighbor) > total_cost:
                        frontier.change_score(neighbor,total_cost)
                        came_from[neighbor] = n
                        if self.show_animation:
                          
                            print('{neighbor} state: F(n)= H(n) = {self.h[neighbor]} = {total_cost}')
                        
    
    def init_graph(self,s,e):
        self.G = nx.Graph()
        self.nodes = list(self.adj.keys())
        self.labels = {}
        for node in self.nodes:
            self.labels[node] = node
            for neighbor, cost in self.adj[node]:
                self.G.add_edge(node,neighbor,weight=cost)
        self.pos = nx.spring_layout(self.G,seed=0)
    
    def update_graph(self,lst):
        edgelst = []
        if len(lst)!=1:
            for i in range(len(lst)-1):
                edgelst.append((lst[i],lst[i+1]))
        else:
            edgelst = lst
        nx.draw_networkx_edges(
            self.G,
            self.pos,
            edgelist=edgelst,
            width=8,
            alpha=0.5,
            edge_color="tab:red",
        )


    def reconstruct_path(self,came_from, s, e):
        path = [e]
        before = came_from[e]
        path.append(before)
        while before != s:
            before = came_from[before]
            path.append(before)
        return path[::-1]
        


if __name__ == '__main__':
    # frontier = PriorityQueue()
    # a = node('a',1)
    # s = node('s',5)
    # v = node('a',10)
    # frontier.push(s)
    # frontier.push(a)
    # frontier.push(v)
    # print(frontier.get_score('s'))
    adjacent_list = {
        'S': [('A', 0),('B', 0)],
        'A': [('C', 0),('D', 0)],
        'B': [('E', 0),('F', 0)],
        'D': [('A', 0),('C', 0),('G', 0)],
        'E': [('A', 0)],
        'F': [('I', 0),('G', 0)]
    }
    heuristic_function = {
        'S': 13,
        'A': 12,
        'B': 4,
        'C': 7,
        'D': 3,
        'E': 8,
        'F': 2,
        'H': 4,
        'I':9,
        'G':0

    }
    solver = bestFirst(adjacent_list, heuristic_function)
    solver.search('S','G')