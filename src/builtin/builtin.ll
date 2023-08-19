; ModuleID = 'builtin.c'
source_filename = "builtin.c"
target datalayout = "e-m:e-p:32:32-p270:32:32-p271:32:32-p272:64:64-f64:32:64-f80:32-n8:16:32-S128"
target triple = "i386-pc-linux-gnu"

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
  %2 = call i32 (ptr, ...) @__isoc99_scanf(ptr noundef @.str.2, ptr noundef %1)
  %3 = load i32, ptr %1, align 4
  ret i32 %3
}

declare i32 @__isoc99_scanf(ptr noundef, ...) #2

; Function Attrs: noinline nounwind optnone uwtable
define dso_local ptr @getString() #0 {
  %1 = alloca ptr, align 4
  %2 = call noalias ptr @malloc(i32 noundef 256) #5
  store ptr %2, ptr %1, align 4
  %3 = load ptr, ptr %1, align 4
  %4 = call i32 (ptr, ...) @__isoc99_scanf(ptr noundef @.str, ptr noundef %3)
  %5 = load ptr, ptr %1, align 4
  ret ptr %5
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local ptr @toString(i32 noundef %0) #0 {
  %2 = alloca i32, align 4
  %3 = alloca i32, align 4
  %4 = alloca i32, align 4
  %5 = alloca i32, align 4
  %6 = alloca ptr, align 4
  %7 = alloca ptr, align 4
  store i32 %0, ptr %2, align 4
  store i32 0, ptr %3, align 4
  store i32 0, ptr %4, align 4
  store i32 0, ptr %5, align 4
  %8 = call noalias ptr @malloc(i32 noundef 11) #5
  store ptr %8, ptr %6, align 4
  %9 = load i32, ptr %2, align 4
  %10 = icmp slt i32 %9, 0
  br i1 %10, label %11, label %14

11:                                               ; preds = %1
  %12 = load i32, ptr %2, align 4
  %13 = sub nsw i32 0, %12
  store i32 %13, ptr %2, align 4
  store i32 1, ptr %4, align 4
  br label %14

14:                                               ; preds = %11, %1
  br label %15

15:                                               ; preds = %26, %14
  %16 = load i32, ptr %2, align 4
  %17 = srem i32 %16, 10
  %18 = add nsw i32 %17, 48
  %19 = trunc i32 %18 to i8
  %20 = load ptr, ptr %6, align 4
  %21 = load i32, ptr %3, align 4
  %22 = add nsw i32 %21, 1
  store i32 %22, ptr %3, align 4
  %23 = getelementptr inbounds i8, ptr %20, i32 %21
  store i8 %19, ptr %23, align 1
  %24 = load i32, ptr %2, align 4
  %25 = sdiv i32 %24, 10
  store i32 %25, ptr %2, align 4
  br label %26

26:                                               ; preds = %15
  %27 = load i32, ptr %2, align 4
  %28 = icmp ne i32 %27, 0
  br i1 %28, label %15, label %29, !llvm.loop !7

29:                                               ; preds = %26
  %30 = load i32, ptr %3, align 4
  %31 = load i32, ptr %4, align 4
  %32 = add nsw i32 %30, %31
  %33 = add nsw i32 %32, 1
  %34 = call noalias ptr @malloc(i32 noundef %33) #5
  store ptr %34, ptr %7, align 4
  %35 = load i32, ptr %4, align 4
  %36 = icmp ne i32 %35, 0
  br i1 %36, label %37, label %42

37:                                               ; preds = %29
  %38 = load ptr, ptr %7, align 4
  %39 = load i32, ptr %5, align 4
  %40 = add nsw i32 %39, 1
  store i32 %40, ptr %5, align 4
  %41 = getelementptr inbounds i8, ptr %38, i32 %39
  store i8 45, ptr %41, align 1
  br label %42

42:                                               ; preds = %37, %29
  br label %43

43:                                               ; preds = %53, %42
  %44 = load ptr, ptr %6, align 4
  %45 = load i32, ptr %3, align 4
  %46 = add nsw i32 %45, -1
  store i32 %46, ptr %3, align 4
  %47 = getelementptr inbounds i8, ptr %44, i32 %46
  %48 = load i8, ptr %47, align 1
  %49 = load ptr, ptr %7, align 4
  %50 = load i32, ptr %5, align 4
  %51 = add nsw i32 %50, 1
  store i32 %51, ptr %5, align 4
  %52 = getelementptr inbounds i8, ptr %49, i32 %50
  store i8 %48, ptr %52, align 1
  br label %53

53:                                               ; preds = %43
  %54 = load i32, ptr %3, align 4
  %55 = icmp ne i32 %54, 0
  br i1 %55, label %43, label %56, !llvm.loop !9

56:                                               ; preds = %53
  %57 = load ptr, ptr %7, align 4
  %58 = load i32, ptr %5, align 4
  %59 = getelementptr inbounds i8, ptr %57, i32 %58
  store i8 0, ptr %59, align 1
  %60 = load ptr, ptr %7, align 4
  ret ptr %60
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @string_length(ptr noundef %0) #0 {
  %2 = alloca ptr, align 4
  store ptr %0, ptr %2, align 4
  %3 = load ptr, ptr %2, align 4
  %4 = call i32 @strlen(ptr noundef %3) #6
  ret i32 %4
}

; Function Attrs: nounwind readonly willreturn
declare i32 @strlen(ptr noundef) #3

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
  br label %16, !llvm.loop !10

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
  %4 = alloca i32, align 4
  %5 = alloca ptr, align 4
  store ptr %0, ptr %2, align 4
  store i32 0, ptr %3, align 4
  store i32 0, ptr %4, align 4
  %6 = load ptr, ptr %2, align 4
  %7 = load i8, ptr %6, align 1
  %8 = sext i8 %7 to i32
  %9 = icmp eq i32 %8, 45
  br i1 %9, label %10, label %11

10:                                               ; preds = %1
  store i32 1, ptr %4, align 4
  br label %11

11:                                               ; preds = %10, %1
  %12 = load ptr, ptr %2, align 4
  store ptr %12, ptr %5, align 4
  br label %13

13:                                               ; preds = %36, %11
  %14 = load ptr, ptr %5, align 4
  %15 = load i8, ptr %14, align 1
  %16 = icmp ne i8 %15, 0
  br i1 %16, label %17, label %39

17:                                               ; preds = %13
  %18 = load ptr, ptr %5, align 4
  %19 = load i8, ptr %18, align 1
  %20 = sext i8 %19 to i32
  %21 = icmp slt i32 %20, 48
  br i1 %21, label %22, label %28

22:                                               ; preds = %17
  %23 = load ptr, ptr %5, align 4
  %24 = load i8, ptr %23, align 1
  %25 = sext i8 %24 to i32
  %26 = icmp sgt i32 %25, 57
  br i1 %26, label %27, label %28

27:                                               ; preds = %22
  br label %39

28:                                               ; preds = %22, %17
  %29 = load i32, ptr %3, align 4
  %30 = mul nsw i32 %29, 10
  %31 = load ptr, ptr %5, align 4
  %32 = load i8, ptr %31, align 1
  %33 = sext i8 %32 to i32
  %34 = add nsw i32 %30, %33
  %35 = sub nsw i32 %34, 48
  store i32 %35, ptr %3, align 4
  br label %36

36:                                               ; preds = %28
  %37 = load ptr, ptr %5, align 4
  %38 = getelementptr inbounds i8, ptr %37, i32 1
  store ptr %38, ptr %5, align 4
  br label %13, !llvm.loop !11

39:                                               ; preds = %27, %13
  %40 = load i32, ptr %4, align 4
  %41 = icmp ne i32 %40, 0
  br i1 %41, label %42, label %45

42:                                               ; preds = %39
  %43 = load i32, ptr %3, align 4
  %44 = sub nsw i32 0, %43
  store i32 %44, ptr %3, align 4
  br label %45

45:                                               ; preds = %42, %39
  %46 = load i32, ptr %3, align 4
  ret i32 %46
}

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
  %7 = call i32 @strlen(ptr noundef %6) #6
  %8 = load ptr, ptr %4, align 4
  %9 = call i32 @strlen(ptr noundef %8) #6
  %10 = add i32 %7, %9
  %11 = add i32 %10, 1
  %12 = call noalias ptr @malloc(i32 noundef %11) #5
  store ptr %12, ptr %5, align 4
  %13 = load ptr, ptr %5, align 4
  %14 = load ptr, ptr %3, align 4
  %15 = call ptr @strcpy(ptr noundef %13, ptr noundef %14) #7
  %16 = load ptr, ptr %5, align 4
  %17 = load ptr, ptr %4, align 4
  %18 = call ptr @strcat(ptr noundef %16, ptr noundef %17) #7
  %19 = load ptr, ptr %5, align 4
  ret ptr %19
}

; Function Attrs: nounwind
declare ptr @strcpy(ptr noundef, ptr noundef) #4

; Function Attrs: nounwind
declare ptr @strcat(ptr noundef, ptr noundef) #4

; Function Attrs: noinline nounwind optnone uwtable
define dso_local zeroext i1 @string_eq(ptr noundef %0, ptr noundef %1) #0 {
  %3 = alloca ptr, align 4
  %4 = alloca ptr, align 4
  store ptr %0, ptr %3, align 4
  store ptr %1, ptr %4, align 4
  %5 = load ptr, ptr %3, align 4
  %6 = load ptr, ptr %4, align 4
  %7 = call i32 @strcmp(ptr noundef %5, ptr noundef %6) #6
  %8 = icmp ne i32 %7, 0
  %9 = xor i1 %8, true
  ret i1 %9
}

; Function Attrs: nounwind readonly willreturn
declare i32 @strcmp(ptr noundef, ptr noundef) #3

; Function Attrs: noinline nounwind optnone uwtable
define dso_local zeroext i1 @string_neq(ptr noundef %0, ptr noundef %1) #0 {
  %3 = alloca ptr, align 4
  %4 = alloca ptr, align 4
  store ptr %0, ptr %3, align 4
  store ptr %1, ptr %4, align 4
  %5 = load ptr, ptr %3, align 4
  %6 = load ptr, ptr %4, align 4
  %7 = call i32 @strcmp(ptr noundef %5, ptr noundef %6) #6
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
  %7 = call i32 @strcmp(ptr noundef %5, ptr noundef %6) #6
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
  %7 = call i32 @strcmp(ptr noundef %5, ptr noundef %6) #6
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
  %7 = call i32 @strcmp(ptr noundef %5, ptr noundef %6) #6
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
  %7 = call i32 @strcmp(ptr noundef %5, ptr noundef %6) #6
  %8 = icmp sge i32 %7, 0
  ret i1 %8
}

attributes #0 = { noinline nounwind optnone uwtable "frame-pointer"="all" "min-legal-vector-width"="0" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="i686" "target-features"="+cx8,+x87" "tune-cpu"="generic" }
attributes #1 = { nounwind allocsize(0) "frame-pointer"="all" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="i686" "target-features"="+cx8,+x87" "tune-cpu"="generic" }
attributes #2 = { "frame-pointer"="all" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="i686" "target-features"="+cx8,+x87" "tune-cpu"="generic" }
attributes #3 = { nounwind readonly willreturn "frame-pointer"="all" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="i686" "target-features"="+cx8,+x87" "tune-cpu"="generic" }
attributes #4 = { nounwind "frame-pointer"="all" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="i686" "target-features"="+cx8,+x87" "tune-cpu"="generic" }
attributes #5 = { nounwind allocsize(0) }
attributes #6 = { nounwind readonly willreturn }
attributes #7 = { nounwind }

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
!9 = distinct !{!9, !8}
!10 = distinct !{!10, !8}
!11 = distinct !{!11, !8}
