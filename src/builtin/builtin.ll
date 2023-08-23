; ModuleID = 'builtin.c'
source_filename = "builtin.c"
target datalayout = "e-m:e-p:32:32-p270:32:32-p271:32:32-p272:64:64-f64:32:64-f80:32-n8:16:32-S128"
target triple = "riscv32-pc-linux-gnu"

@.str = private unnamed_addr constant [3 x i8] c"%s\00", align 1
@.str.1 = private unnamed_addr constant [4 x i8] c"%s\0A\00", align 1
@.str.2 = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@.str.3 = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local ptr @array_malloc(i32 noundef %0) #0 {
  %2 = alloca i32, align 4
  %3 = alloca ptr, align 4
  store i32 %0, ptr %2, align 4
  %4 = load i32, ptr %2, align 4
  %5 = mul nsw i32 %4, 4
  %6 = add nsw i32 %5, 4
  %7 = call noalias ptr @malloc(i32 noundef %6) #5
  store ptr %7, ptr %3, align 4
  %8 = load i32, ptr %2, align 4
  %9 = load ptr, ptr %3, align 4
  %10 = getelementptr inbounds i32, ptr %9, i32 0
  store i32 %8, ptr %10, align 4
  %11 = load ptr, ptr %3, align 4
  %12 = getelementptr inbounds i32, ptr %11, i32 1
  ret ptr %12
}

; Function Attrs: nounwind allocsize(0)
declare noalias ptr @malloc(i32 noundef) #1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local ptr @class_malloc(i32 noundef %0) #0 {
  %2 = alloca i32, align 4
  %3 = alloca ptr, align 4
  store i32 %0, ptr %2, align 4
  %4 = load i32, ptr %2, align 4
  %5 = call noalias ptr @malloc(i32 noundef %4) #5
  store ptr %5, ptr %3, align 4
  %6 = load ptr, ptr %3, align 4
  ret ptr %6
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @print(ptr noundef %0) #0 {
  %2 = alloca ptr, align 4
  store ptr %0, ptr %2, align 4
  %3 = load ptr, ptr %2, align 4
  %4 = call i32 (ptr, ...) @printf(ptr noundef @.str, ptr noundef %3)
  ret void
}

declare i32 @printf(ptr noundef, ...) #2

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @println(ptr noundef %0) #0 {
  %2 = alloca ptr, align 4
  store ptr %0, ptr %2, align 4
  %3 = load ptr, ptr %2, align 4
  %4 = call i32 (ptr, ...) @printf(ptr noundef @.str.1, ptr noundef %3)
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @printInt(i32 noundef %0) #0 {
  %2 = alloca i32, align 4
  store i32 %0, ptr %2, align 4
  %3 = load i32, ptr %2, align 4
  %4 = call i32 (ptr, ...) @printf(ptr noundef @.str.2, i32 noundef %3)
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @printlnInt(i32 noundef %0) #0 {
  %2 = alloca i32, align 4
  store i32 %0, ptr %2, align 4
  %3 = load i32, ptr %2, align 4
  %4 = call i32 (ptr, ...) @printf(ptr noundef @.str.3, i32 noundef %3)
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @getInt() #0 {
  %1 = alloca i32, align 4
  %2 = call i32 (ptr, ...) @scanf(ptr noundef @.str.2, ptr noundef %1)
  %3 = load i32, ptr %1, align 4
  ret i32 %3
}

declare i32 @scanf(ptr noundef, ...) #2

; Function Attrs: noinline nounwind optnone uwtable
define dso_local ptr @getString() #0 {
  %1 = alloca ptr, align 4
  %2 = call noalias ptr @malloc(i32 noundef 256) #5
  store ptr %2, ptr %1, align 4
  %3 = load ptr, ptr %1, align 4
  %4 = call i32 (ptr, ...) @scanf(ptr noundef @.str, ptr noundef %3)
  %5 = load ptr, ptr %1, align 4
  ret ptr %5
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local ptr @toString(i32 noundef %0) #0 {
  %2 = alloca i32, align 4
  %3 = alloca ptr, align 4
  store i32 %0, ptr %2, align 4
  %4 = call noalias ptr @malloc(i32 noundef 20) #5
  store ptr %4, ptr %3, align 4
  %5 = load ptr, ptr %3, align 4
  %6 = load i32, ptr %2, align 4
  %7 = call i32 (ptr, ptr, ...) @sprintf(ptr noundef %5, ptr noundef @.str.2, i32 noundef %6) #6
  %8 = load ptr, ptr %3, align 4
  ret ptr %8
}

; Function Attrs: nounwind
declare i32 @sprintf(ptr noundef, ptr noundef, ...) #3

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @string_length(ptr noundef %0) #0 {
  %2 = alloca ptr, align 4
  store ptr %0, ptr %2, align 4
  %3 = load ptr, ptr %2, align 4
  %4 = call i32 @strlen(ptr noundef %3) #7
  ret i32 %4
}

; Function Attrs: nounwind readonly willreturn
declare i32 @strlen(ptr noundef) #4

; Function Attrs: noinline nounwind optnone uwtable
define dso_local ptr @string_substring(ptr noundef %0, i32 noundef %1, i32 noundef %2) #0 {
  %4 = alloca ptr, align 4
  %5 = alloca i32, align 4
  %6 = alloca i32, align 4
  %7 = alloca ptr, align 4
  %8 = alloca i32, align 4
  %9 = alloca i32, align 4
  store ptr %0, ptr %4, align 4
  store i32 %1, ptr %5, align 4
  store i32 %2, ptr %6, align 4
  %10 = load i32, ptr %6, align 4
  %11 = load i32, ptr %5, align 4
  %12 = sub nsw i32 %10, %11
  %13 = add nsw i32 %12, 1
  %14 = call noalias ptr @malloc(i32 noundef %13) #5
  store ptr %14, ptr %7, align 4
  store i32 0, ptr %8, align 4
  %15 = load i32, ptr %5, align 4
  store i32 %15, ptr %9, align 4
  br label %16

16:                                               ; preds = %29, %3
  %17 = load i32, ptr %9, align 4
  %18 = load i32, ptr %6, align 4
  %19 = icmp slt i32 %17, %18
  br i1 %19, label %20, label %32

20:                                               ; preds = %16
  %21 = load ptr, ptr %4, align 4
  %22 = load i32, ptr %9, align 4
  %23 = getelementptr inbounds i8, ptr %21, i32 %22
  %24 = load i8, ptr %23, align 1
  %25 = load ptr, ptr %7, align 4
  %26 = load i32, ptr %8, align 4
  %27 = add nsw i32 %26, 1
  store i32 %27, ptr %8, align 4
  %28 = getelementptr inbounds i8, ptr %25, i32 %26
  store i8 %24, ptr %28, align 1
  br label %29

29:                                               ; preds = %20
  %30 = load i32, ptr %9, align 4
  %31 = add nsw i32 %30, 1
  store i32 %31, ptr %9, align 4
  br label %16, !llvm.loop !7

32:                                               ; preds = %16
  %33 = load ptr, ptr %7, align 4
  %34 = load i32, ptr %8, align 4
  %35 = getelementptr inbounds i8, ptr %33, i32 %34
  store i8 0, ptr %35, align 1
  %36 = load ptr, ptr %7, align 4
  ret ptr %36
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @array_size(ptr noundef %0) #0 {
  %2 = alloca ptr, align 4
  store ptr %0, ptr %2, align 4
  %3 = load ptr, ptr %2, align 4
  %4 = getelementptr inbounds i8, ptr %3, i32 -4
  %5 = load i32, ptr %4, align 4
  ret i32 %5
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @string_parseInt(ptr noundef %0) #0 {
  %2 = alloca ptr, align 4
  %3 = alloca i32, align 4
  store ptr %0, ptr %2, align 4
  %4 = load ptr, ptr %2, align 4
  %5 = call i32 (ptr, ptr, ...) @sscanf(ptr noundef %4, ptr noundef @.str.2, ptr noundef %3) #6
  %6 = load i32, ptr %3, align 4
  ret i32 %6
}

; Function Attrs: nounwind
declare i32 @sscanf(ptr noundef, ptr noundef, ...) #3

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @string_ord(ptr noundef %0, i32 noundef %1) #0 {
  %3 = alloca ptr, align 4
  %4 = alloca i32, align 4
  store ptr %0, ptr %3, align 4
  store i32 %1, ptr %4, align 4
  %5 = load ptr, ptr %3, align 4
  %6 = load i32, ptr %4, align 4
  %7 = getelementptr inbounds i8, ptr %5, i32 %6
  %8 = load i8, ptr %7, align 1
  %9 = sext i8 %8 to i32
  ret i32 %9
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local ptr @string_add(ptr noundef %0, ptr noundef %1) #0 {
  %3 = alloca ptr, align 4
  %4 = alloca ptr, align 4
  %5 = alloca ptr, align 4
  store ptr %0, ptr %3, align 4
  store ptr %1, ptr %4, align 4
  %6 = load ptr, ptr %3, align 4
  %7 = call i32 @strlen(ptr noundef %6) #7
  %8 = load ptr, ptr %4, align 4
  %9 = call i32 @strlen(ptr noundef %8) #7
  %10 = add i32 %7, %9
  %11 = add i32 %10, 1
  %12 = call noalias ptr @malloc(i32 noundef %11) #5
  store ptr %12, ptr %5, align 4
  %13 = load ptr, ptr %5, align 4
  %14 = load ptr, ptr %3, align 4
  %15 = call ptr @strcpy(ptr noundef %13, ptr noundef %14) #6
  %16 = load ptr, ptr %5, align 4
  %17 = load ptr, ptr %4, align 4
  %18 = call ptr @strcat(ptr noundef %16, ptr noundef %17) #6
  %19 = load ptr, ptr %5, align 4
  ret ptr %19
}

; Function Attrs: nounwind
declare ptr @strcpy(ptr noundef, ptr noundef) #3

; Function Attrs: nounwind
declare ptr @strcat(ptr noundef, ptr noundef) #3

; Function Attrs: noinline nounwind optnone uwtable
define dso_local zeroext i1 @string_eq(ptr noundef %0, ptr noundef %1) #0 {
  %3 = alloca ptr, align 4
  %4 = alloca ptr, align 4
  store ptr %0, ptr %3, align 4
  store ptr %1, ptr %4, align 4
  %5 = load ptr, ptr %3, align 4
  %6 = load ptr, ptr %4, align 4
  %7 = call i32 @strcmp(ptr noundef %5, ptr noundef %6) #7
  %8 = icmp ne i32 %7, 0
  %9 = xor i1 %8, true
  ret i1 %9
}

; Function Attrs: nounwind readonly willreturn
declare i32 @strcmp(ptr noundef, ptr noundef) #4

; Function Attrs: noinline nounwind optnone uwtable
define dso_local zeroext i1 @string_neq(ptr noundef %0, ptr noundef %1) #0 {
  %3 = alloca ptr, align 4
  %4 = alloca ptr, align 4
  store ptr %0, ptr %3, align 4
  store ptr %1, ptr %4, align 4
  %5 = load ptr, ptr %3, align 4
  %6 = load ptr, ptr %4, align 4
  %7 = call i32 @strcmp(ptr noundef %5, ptr noundef %6) #7
  %8 = icmp ne i32 %7, 0
  ret i1 %8
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local zeroext i1 @string_lt(ptr noundef %0, ptr noundef %1) #0 {
  %3 = alloca ptr, align 4
  %4 = alloca ptr, align 4
  store ptr %0, ptr %3, align 4
  store ptr %1, ptr %4, align 4
  %5 = load ptr, ptr %3, align 4
  %6 = load ptr, ptr %4, align 4
  %7 = call i32 @strcmp(ptr noundef %5, ptr noundef %6) #7
  %8 = icmp slt i32 %7, 0
  ret i1 %8
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local zeroext i1 @string_le(ptr noundef %0, ptr noundef %1) #0 {
  %3 = alloca ptr, align 4
  %4 = alloca ptr, align 4
  store ptr %0, ptr %3, align 4
  store ptr %1, ptr %4, align 4
  %5 = load ptr, ptr %3, align 4
  %6 = load ptr, ptr %4, align 4
  %7 = call i32 @strcmp(ptr noundef %5, ptr noundef %6) #7
  %8 = icmp sle i32 %7, 0
  ret i1 %8
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local zeroext i1 @string_gt(ptr noundef %0, ptr noundef %1) #0 {
  %3 = alloca ptr, align 4
  %4 = alloca ptr, align 4
  store ptr %0, ptr %3, align 4
  store ptr %1, ptr %4, align 4
  %5 = load ptr, ptr %3, align 4
  %6 = load ptr, ptr %4, align 4
  %7 = call i32 @strcmp(ptr noundef %5, ptr noundef %6) #7
  %8 = icmp sgt i32 %7, 0
  ret i1 %8
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local zeroext i1 @string_ge(ptr noundef %0, ptr noundef %1) #0 {
  %3 = alloca ptr, align 4
  %4 = alloca ptr, align 4
  store ptr %0, ptr %3, align 4
  store ptr %1, ptr %4, align 4
  %5 = load ptr, ptr %3, align 4
  %6 = load ptr, ptr %4, align 4
  %7 = call i32 @strcmp(ptr noundef %5, ptr noundef %6) #7
  %8 = icmp sge i32 %7, 0
  ret i1 %8
}

!llvm.module.flags = !{!0, !1, !2, !3, !4, !5}
!llvm.ident = !{!6}

!0 = !{i32 1, !"NumRegisterParameters", i32 0}
!1 = !{i32 1, !"wchar_size", i32 4}
!2 = !{i32 7, !"PIC Level", i32 2}
!3 = !{i32 7, !"PIE Level", i32 2}
!4 = !{i32 7, !"uwtable", i32 2}
!5 = !{i32 7, !"frame-pointer", i32 2}
!6 = !{!"Ubuntu clang version 15.0.7"}
!7 = distinct !{!7, !8}
!8 = !{!"llvm.loop.mustprogress"}
