# @executor: 指令书掉落物
# 因为凋暴模组不开源, 所以用 mcfunction 实现命令书无敌+高亮+禁止猎人捡起
# 这样也带来另一个好处：临时维护时，可以直接修改.mcfunction文件，不用重新编译模组

# 发光
data modify entity @s Glowing set value 1b

# 无敌
data modify entity @s Health set value 11451.4f
data modify entity @s Invulnerable set value 1b

# 防止5分钟刷没
data modify entity @s Age set value 0s

# 阻止猎人捡起
data modify entity @s Owner set from entity @s UUID
data modify entity @s Owner set from entity @p[distance=..2,team=runners] UUID
