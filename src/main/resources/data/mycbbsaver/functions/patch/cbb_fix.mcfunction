# @executor: 指令书掉落物

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
