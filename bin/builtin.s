	.text
	.attribute	4, 16
	.attribute	5, "rv32i2p0"
	.file	"builtin.c"
	.globl	array_malloc                    # -- Begin function array_malloc
	.p2align	2
	.type	array_malloc,@function
array_malloc:                           # @array_malloc
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	lw	a0, 8(sp)
	slli	a0, a0, 2
	addi	a0, a0, 4
	call	malloc
	sw	a0, 4(sp)
	lw	a0, 8(sp)
	lw	a1, 4(sp)
	sw	a0, 0(a1)
	lw	a0, 4(sp)
	addi	a0, a0, 4
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end0:
	.size	array_malloc, .Lfunc_end0-array_malloc
	.cfi_endproc
                                        # -- End function
	.globl	class_malloc                    # -- Begin function class_malloc
	.p2align	2
	.type	class_malloc,@function
class_malloc:                           # @class_malloc
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	lw	a0, 8(sp)
	call	malloc
	sw	a0, 4(sp)
	lw	a0, 4(sp)
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end1:
	.size	class_malloc, .Lfunc_end1-class_malloc
	.cfi_endproc
                                        # -- End function
	.globl	print                           # -- Begin function print
	.p2align	2
	.type	print,@function
print:                                  # @print
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	lw	a1, 8(sp)
	lui	a0, %hi(.L.str)
	addi	a0, a0, %lo(.L.str)
	call	printf
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end2:
	.size	print, .Lfunc_end2-print
	.cfi_endproc
                                        # -- End function
	.globl	println                         # -- Begin function println
	.p2align	2
	.type	println,@function
println:                                # @println
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	lw	a1, 8(sp)
	lui	a0, %hi(.L.str.1)
	addi	a0, a0, %lo(.L.str.1)
	call	printf
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end3:
	.size	println, .Lfunc_end3-println
	.cfi_endproc
                                        # -- End function
	.globl	printInt                        # -- Begin function printInt
	.p2align	2
	.type	printInt,@function
printInt:                               # @printInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	lw	a1, 8(sp)
	lui	a0, %hi(.L.str.2)
	addi	a0, a0, %lo(.L.str.2)
	call	printf
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end4:
	.size	printInt, .Lfunc_end4-printInt
	.cfi_endproc
                                        # -- End function
	.globl	printlnInt                      # -- Begin function printlnInt
	.p2align	2
	.type	printlnInt,@function
printlnInt:                             # @printlnInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	lw	a1, 8(sp)
	lui	a0, %hi(.L.str.3)
	addi	a0, a0, %lo(.L.str.3)
	call	printf
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end5:
	.size	printlnInt, .Lfunc_end5-printlnInt
	.cfi_endproc
                                        # -- End function
	.globl	getInt                          # -- Begin function getInt
	.p2align	2
	.type	getInt,@function
getInt:                                 # @getInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	lui	a0, %hi(.L.str.2)
	addi	a0, a0, %lo(.L.str.2)
	addi	a1, sp, 8
	call	scanf
	lw	a0, 8(sp)
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end6:
	.size	getInt, .Lfunc_end6-getInt
	.cfi_endproc
                                        # -- End function
	.globl	getString                       # -- Begin function getString
	.p2align	2
	.type	getString,@function
getString:                              # @getString
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	li	a0, 256
	call	malloc
	sw	a0, 8(sp)
	lw	a1, 8(sp)
	lui	a0, %hi(.L.str)
	addi	a0, a0, %lo(.L.str)
	call	scanf
	lw	a0, 8(sp)
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end7:
	.size	getString, .Lfunc_end7-getString
	.cfi_endproc
                                        # -- End function
	.globl	toString                        # -- Begin function toString
	.p2align	2
	.type	toString,@function
toString:                               # @toString
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	li	a0, 20
	call	malloc
	sw	a0, 4(sp)
	lw	a0, 4(sp)
	lw	a2, 8(sp)
	lui	a1, %hi(.L.str.2)
	addi	a1, a1, %lo(.L.str.2)
	call	sprintf
	lw	a0, 4(sp)
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end8:
	.size	toString, .Lfunc_end8-toString
	.cfi_endproc
                                        # -- End function
	.globl	string_length                   # -- Begin function string_length
	.p2align	2
	.type	string_length,@function
string_length:                          # @string_length
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	lw	a0, 8(sp)
	call	strlen
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end9:
	.size	string_length, .Lfunc_end9-string_length
	.cfi_endproc
                                        # -- End function
	.globl	string_substring                # -- Begin function string_substring
	.p2align	2
	.type	string_substring,@function
string_substring:                       # @string_substring
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 24(sp)
	sw	a1, 20(sp)
	sw	a2, 16(sp)
	lw	a0, 16(sp)
	lw	a1, 20(sp)
	sub	a0, a0, a1
	addi	a0, a0, 1
	call	malloc
	sw	a0, 12(sp)
	li	a0, 0
	sw	a0, 8(sp)
	lw	a0, 20(sp)
	sw	a0, 4(sp)
	j	.LBB10_1
.LBB10_1:                               # =>This Inner Loop Header: Depth=1
	lw	a0, 4(sp)
	lw	a1, 16(sp)
	bge	a0, a1, .LBB10_4
	j	.LBB10_2
.LBB10_2:                               #   in Loop: Header=BB10_1 Depth=1
	lw	a0, 24(sp)
	lw	a1, 4(sp)
	add	a0, a0, a1
	lb	a0, 0(a0)
	lw	a1, 12(sp)
	lw	a2, 8(sp)
	addi	a3, a2, 1
	sw	a3, 8(sp)
	add	a1, a1, a2
	sb	a0, 0(a1)
	j	.LBB10_3
.LBB10_3:                               #   in Loop: Header=BB10_1 Depth=1
	lw	a0, 4(sp)
	addi	a0, a0, 1
	sw	a0, 4(sp)
	j	.LBB10_1
.LBB10_4:
	lw	a0, 12(sp)
	lw	a1, 8(sp)
	add	a1, a0, a1
	li	a0, 0
	sb	a0, 0(a1)
	lw	a0, 12(sp)
	lw	ra, 28(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 32
	ret
.Lfunc_end10:
	.size	string_substring, .Lfunc_end10-string_substring
	.cfi_endproc
                                        # -- End function
	.globl	array_size                      # -- Begin function array_size
	.p2align	2
	.type	array_size,@function
array_size:                             # @array_size
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	a0, 12(sp)
	lw	a0, 12(sp)
	lw	a0, -4(a0)
	addi	sp, sp, 16
	ret
.Lfunc_end11:
	.size	array_size, .Lfunc_end11-array_size
	.cfi_endproc
                                        # -- End function
	.globl	string_parseInt                 # -- Begin function string_parseInt
	.p2align	2
	.type	string_parseInt,@function
string_parseInt:                        # @string_parseInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	lw	a0, 8(sp)
	lui	a1, %hi(.L.str.2)
	addi	a1, a1, %lo(.L.str.2)
	addi	a2, sp, 4
	call	sscanf
	lw	a0, 4(sp)
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end12:
	.size	string_parseInt, .Lfunc_end12-string_parseInt
	.cfi_endproc
                                        # -- End function
	.globl	string_ord                      # -- Begin function string_ord
	.p2align	2
	.type	string_ord,@function
string_ord:                             # @string_ord
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	a0, 12(sp)
	sw	a1, 8(sp)
	lw	a0, 12(sp)
	lw	a1, 8(sp)
	add	a0, a0, a1
	lb	a0, 0(a0)
	addi	sp, sp, 16
	ret
.Lfunc_end13:
	.size	string_ord, .Lfunc_end13-string_ord
	.cfi_endproc
                                        # -- End function
	.globl	string_add                      # -- Begin function string_add
	.p2align	2
	.type	string_add,@function
string_add:                             # @string_add
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 24(sp)
	sw	a1, 20(sp)
	lw	a0, 24(sp)
	call	strlen
	sw	a0, 12(sp)                      # 4-byte Folded Spill
	lw	a0, 20(sp)
	call	strlen
	mv	a1, a0
	lw	a0, 12(sp)                      # 4-byte Folded Reload
	add	a0, a0, a1
	addi	a0, a0, 1
	call	malloc
	sw	a0, 16(sp)
	lw	a0, 16(sp)
	lw	a1, 24(sp)
	call	strcpy
	lw	a0, 16(sp)
	lw	a1, 20(sp)
	call	strcat
	lw	a0, 16(sp)
	lw	ra, 28(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 32
	ret
.Lfunc_end14:
	.size	string_add, .Lfunc_end14-string_add
	.cfi_endproc
                                        # -- End function
	.globl	string_eq                       # -- Begin function string_eq
	.p2align	2
	.type	string_eq,@function
string_eq:                              # @string_eq
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	sw	a1, 4(sp)
	lw	a0, 8(sp)
	lw	a1, 4(sp)
	call	strcmp
	seqz	a0, a0
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end15:
	.size	string_eq, .Lfunc_end15-string_eq
	.cfi_endproc
                                        # -- End function
	.globl	string_neq                      # -- Begin function string_neq
	.p2align	2
	.type	string_neq,@function
string_neq:                             # @string_neq
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	sw	a1, 4(sp)
	lw	a0, 8(sp)
	lw	a1, 4(sp)
	call	strcmp
	snez	a0, a0
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end16:
	.size	string_neq, .Lfunc_end16-string_neq
	.cfi_endproc
                                        # -- End function
	.globl	string_lt                       # -- Begin function string_lt
	.p2align	2
	.type	string_lt,@function
string_lt:                              # @string_lt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	sw	a1, 4(sp)
	lw	a0, 8(sp)
	lw	a1, 4(sp)
	call	strcmp
	srli	a0, a0, 31
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end17:
	.size	string_lt, .Lfunc_end17-string_lt
	.cfi_endproc
                                        # -- End function
	.globl	string_le                       # -- Begin function string_le
	.p2align	2
	.type	string_le,@function
string_le:                              # @string_le
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	sw	a1, 4(sp)
	lw	a0, 8(sp)
	lw	a1, 4(sp)
	call	strcmp
	slti	a0, a0, 1
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end18:
	.size	string_le, .Lfunc_end18-string_le
	.cfi_endproc
                                        # -- End function
	.globl	string_gt                       # -- Begin function string_gt
	.p2align	2
	.type	string_gt,@function
string_gt:                              # @string_gt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	sw	a1, 4(sp)
	lw	a0, 8(sp)
	lw	a1, 4(sp)
	call	strcmp
	mv	a1, a0
	li	a0, 0
	slt	a0, a0, a1
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end19:
	.size	string_gt, .Lfunc_end19-string_gt
	.cfi_endproc
                                        # -- End function
	.globl	string_ge                       # -- Begin function string_ge
	.p2align	2
	.type	string_ge,@function
string_ge:                              # @string_ge
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)                      # 4-byte Folded Spill
	.cfi_offset ra, -4
	sw	a0, 8(sp)
	sw	a1, 4(sp)
	lw	a0, 8(sp)
	lw	a1, 4(sp)
	call	strcmp
	not	a0, a0
	srli	a0, a0, 31
	lw	ra, 12(sp)                      # 4-byte Folded Reload
	addi	sp, sp, 16
	ret
.Lfunc_end20:
	.size	string_ge, .Lfunc_end20-string_ge
	.cfi_endproc
                                        # -- End function
	.type	.L.str,@object                  # @.str
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str:
	.asciz	"%s"
	.size	.L.str, 3

	.type	.L.str.1,@object                # @.str.1
.L.str.1:
	.asciz	"%s\n"
	.size	.L.str.1, 4

	.type	.L.str.2,@object                # @.str.2
.L.str.2:
	.asciz	"%d"
	.size	.L.str.2, 3

	.type	.L.str.3,@object                # @.str.3
.L.str.3:
	.asciz	"%d\n"
	.size	.L.str.3, 4

	.ident	"Ubuntu clang version 15.0.7"
	.section	".note.GNU-stack","",@progbits
