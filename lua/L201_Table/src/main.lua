-- Table
Config = {}
Config.words = "Hello"
Config.num = 100
Config["name"] = "zhangsan"

--print(Config.words)
--print(Config["words"])
--print(Config.name)

Config1 = { hello = "hello lua", world = "world"}

--print(Config1.hello)
--print(Config1["world"])

-- ±éÀú
for key, var in pairs(Config) do
	print(key, var)
end