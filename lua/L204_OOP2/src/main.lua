-- ʹ�ñհ���ʵ���������
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

-- ʵ�ּ̳�
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