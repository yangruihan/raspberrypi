-- 注释
-- print("Hello Lua")

-- 全局变量
num = 100

-- 局部变量
local num_local = 100

-- 方法
function sayHello()
  print("Hello Lua")
end

-- 带参数的方法
function max(a, b)
  if a>b then
    return a
  else
    return b
  end
end

-- 循环（包括0和9）
for var=0, 9 do
  print (var)
end
