-- ����Lua������������ؼ��֣�������Ҫ��table��ģ����ʵ��

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
  print("People say Hi "..self.name)
end

People.new = function (name)
  local self = clone(People)
  self.name = name
  return self
end

local p = People.new("Zhangsan")
--p.sayHi(p)
p:sayHi() -- ���������ʽ��ͬ��Ĭ�Ͻ�����������һ����������

-- �̳е�ʵ��
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

-- �����·���
Man.sayHello = function ()
	print("Man say hello")
end

-- �̳з���
local m = Man.new("lisi")
m:sayHi()

-- ��д����
Man.sayHi = function (self)
	print("Man say Hi "..self.name)
end

m = Man.new("lisi")
m:sayHi()