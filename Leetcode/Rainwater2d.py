
class Solution:
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

h =[4,2,0,3,2,5]
s = Solution()
water = s.trap(h)
print(water)

