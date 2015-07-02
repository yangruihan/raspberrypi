-- ����Lua����������ؼ��֣�������Ҫ��table��ģ����ʵ��

-- �����½���ʵ��
function clone(tab)
	local ins = {}
	for key, var in pairs(tab) do
		ins[key] = var
	end
	return ins
end

-- ����һ����
People = {}
-- �����෽��

--function People.sayHi()
--  print("Hello")
--end

-- ".."Ϊ�ַ�������
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
p:sayHi() -- ���������ʽ��ͬ��Ĭ�Ͻ���������һ����������