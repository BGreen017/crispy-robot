def heuristic(a, b):    # The heuristic acts as a controller of direction of our search towards the goal
    (x1, y1) = a
    (x2, y2) = b
    return abs(x1 - x2) + abs(y1 - y2)    # In this situation the heuristic is determined by the distance function

def a_star_search(graph, start, goal):    # A* search algorithm, a basic search algorithm with targeted searching 
    frontier = PriorityQueue()    # priority queue is a little complicated, see comments below
    frontier.put(start, 0)     # creates our intitial UAV startpoint and assigns the priority to zero
    came_from = {}    # initializes array for visited nodes
    cost_so_far = {}   # initializes minimum cost paths
    came_from[start] = None  
    cost_so_far[start] = 0
    
    while not frontier.empty():
        current = frontier.get()
        
        if current == goal:
            break
        
        for next in graph.neighbors(current):  # next works as an index and neigbors returns the 4 surrounding nodes of current location and will act a bounds for the nested loop 
            new_cost = cost_so_far[current] + graph.cost(current, next)  # cost is the weight associated with each node see commments for more  
            if next not in cost_so_far or new_cost < cost_so_far[next]:   # checks for minimum path
                cost_so_far[next] = new_cost  # 
                priority = new_cost + heuristic(goal, next)  # provides a balanced oblstacle avoidance directional check. 
                frontier.put(next, priority)
                came_from[next] = current  # stores visited points
    
    return came_from, cost_so_far   # returns visited points and minimum cost path for path construction 
