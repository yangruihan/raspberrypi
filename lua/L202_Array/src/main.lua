-- Array
arr = {1, 2, 3, 4, "Hello"}

-- ע�⣬��Lua�У�����������Ǵ�1��ʼ
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

-- ������鳤��
print(table.maxn(arr1))
