-- 使用闭包来实现面向对象
function People(name)
	local self = {}
	
	local function init()
		self.name = name
	end
	
	self.sayHi = function ()
		print("Hi "..self.name)
	end
	
	init()
	return self
end

local p = People("zhangsan")
p:sayHi()

-- 实现继承
function Man(name)
	local self = People(name)
	
	self.sayHello = function()
	 print("Hello "..self.name)
	end
	
	return self
end

local m = Man("lisi")
m:sayHi()
m:sayHello()