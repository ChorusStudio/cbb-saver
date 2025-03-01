# 因为凋暴模组不开源, 所以只好用 mcfunction 实现命令书无敌+高亮+禁止猎人捡起
# 这样也带来另一个好处：临时维护时，可以直接修改.mcfunction文件，不用重新编译模组

## 命令书修复（无敌+高亮+禁止猎人捡起）
execute as @e[type=item,nbt={Item:{id:"witherstormmod:command_block_book"}}] at @s run function mycbbsaver:patch/cbb_fix