# max rectangle area: depends on both horizontal and vertical length
# Strategy 1: fix one vertical edge and loop through the rest to find the max possible area with that fixed edge (O(n^2))
# Strategy 2: dynamically traverse from both edge; two pointer (O(n))

class Solution:
    def maxArea(self, height: List[int]) -> int:
        lcursor:int=0
        rcursor:int=len(height)-1
        max_area:int=0
        width:int=rcursor
        while lcursor < rcursor:     
            if(height[lcursor] >= height[rcursor]):              
                area=height[rcursor]*width
                rcursor-=1
            else:               
                area=height[lcursor]*width
                lcursor+=1

            if(max_area < area):
                max_area=area
            width-=1
        return max_area