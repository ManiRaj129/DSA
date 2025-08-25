
class Solution:
    #Nested loop
    def trap(self, height: list[int]) -> int:
        lmax:int=0
        water_units:int=0
        for i in range(1,len(height)):
            if lmax < height[i-1]:
                lmax = height[i-1]
            rmax:int=0
            for j in range(i+1,len(height)):
                if rmax < height[j]:
                    rmax = height[j]
            if height[i] < min(lmax,rmax):
                water_units += min(lmax,rmax) - height[i]
        return water_units
    
    #2 pointer
    def trap2(self, height: list[int]) -> int:
        lmax_index:int=0
        rmax_index:int=len(height)-1
        lcursor:int=1
        rcursor:int=rmax_index -1
        water_units:int=0
        while(lcursor <= rcursor):
            if height[lmax_index] <= height[rmax_index]:
                if height[lmax_index] > height[lcursor]:
                    water_units += height[lmax_index] - height[lcursor]
                else :
                    lmax_index =lcursor
                lcursor +=1                
            else:
                if height[rmax_index] > height[rcursor]:
                    water_units += height[rmax_index]-height[rcursor]
                else :
                    rmax_index =rcursor
                rcursor -=1
        return water_units


                

                





h =[0,1,0,2,1,0,1,3,2,1,2,1]
s = Solution()
water = s.trap2(h)
print(water)


