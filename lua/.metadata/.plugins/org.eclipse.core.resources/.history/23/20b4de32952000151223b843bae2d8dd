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
	print("Hello "..self.name)
end

People.new = function (name)
  local self = clone(People)
  self.name = name
  return self
end

local p = People.new("Zhangsan")
--p.sayHi(p)
p:sayHi() -- 与上面的形式相同，默认将自身当做第一个参数传递