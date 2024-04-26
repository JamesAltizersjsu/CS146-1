basically to solve this we first initialize a dynamic programming array(dp) with 'INF' values,
we then initialize the values for minimum distances and the list of lists which make up our edges. 
we then implement a warshalls algorithmn by having three nested for loops set the distance between 2 nodes or cities
equal to the minimum of the various combinations of path lengths to reach a destination node
after that we iterate through the given list of nodes and edges and count up the reachable cities for each 
respective city within the minimum distance threshold, then picking the minimum. it returns the 0-indexed
city which has the minimum reachable cities within for the sake of this example, 4, with city 3 being the 
result. We return the result.
