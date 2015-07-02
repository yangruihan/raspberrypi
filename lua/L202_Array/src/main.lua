-- Array
arr = {1, 2, 3, 4, "Hello"}

-- 注意，在Lua中，数组的索引是从1开始
for key, var in pairs(arr) do
	print(key, var)
end

arr1 = {}

for var = 1, 100 do
  table.insert(arr1, var, var)
end

for key, var in pairs(arr1) do
	print(key, var)
end

-- 获得数组长度
print(table.maxn(arr1))

