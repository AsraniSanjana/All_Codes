MAX, MIN = 1000, -1000
 
# Returns optimal value for current player
#(Initially called for root and maximizer)
def minimax(depth, nodeIndex, maximizingPlayer,
            values, alpha, beta):
  
    # Terminating condition. i.e
    # leaf node is reached
    if depth == 3:
        return values[nodeIndex]
 
    if maximizingPlayer:
      
        best = MIN
 
        # Recur for left and right children
        for i in range(0, 2):
             
            val = minimax(depth + 1, nodeIndex * 2 + i,
                          False, values, alpha, beta)
            best = max(best, val)
            
            alpha = max(alpha, best)

            print("parsingMax",best)
            

            # Alpha Beta Pruning
            if beta <= alpha:
                break
            print("selectingMax",alpha)
        return best
      
    else:
        best = MAX
 
        # Recur for left and
        # right children
        for i in range(0, 2):
          
            val = minimax(depth + 1, nodeIndex * 2 + i,
                            True, values, alpha, beta)
            best = min(best, val)
            beta = min(beta, best)
            
            print("parsingMin",best)


 
            # Alpha Beta Pruning
            if beta <= alpha:
                break
            print("selectingMin",beta)
        return best
      
# Driver Code
if __name__ == "__main__":
  
  values = [3,4,2,1,7,8,9,10,2,11,1,12,14,9,13,16] 
  print("The optimal value is :", minimax(0, 0, False, values, MIN, MAX))

    #  if u want min(10,3) min(4,7)... pass False... This is min case

     