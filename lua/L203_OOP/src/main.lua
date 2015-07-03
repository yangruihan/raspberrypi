-- 由于Lua本身不含有类关键字，所以需要用table来模拟类实现

-- 用来新建类实例
function clone(tab)
  local ins = {}
  for key, var in pairs(tab) do
    ins[key] = var
  end
  return ins
end

-- 定义一个类
People = {}
-- 定义类方法

--function People.sayHi()
--  print("Hello")
--end

-- ".."为字符串连接
People.sayHi = function (self)
  print("People say Hi "..self.name)
end

People.new = function (name)
  local self = clone(People)
  self.name = name
  return self
end

local p = People.new("Zhangsan")
--p.sayHi(p)
p:sayHi() -- 与上面的形式相同，默认将自身当做第一个参数传递

-- 继承的实现
function copy(dist, tab)
  for key, var in pairs(tab) do
    dist[key] = var
  end
end

Man = {}
Man.new = function (name)
  local self = People.new(name)
  copy(self, Man)
  return self
end

-- 定义新方法
Man.sayHello = function ()
	print("Man say hello")
end

-- 继承方法
local m = Man.new("lisi")
m:sayHi()

-- 覆写方法
Man.sayHi = function (self)
	print("Man say Hi "..self.name)
end

m = Man.new("lisi")
m:sayHi()