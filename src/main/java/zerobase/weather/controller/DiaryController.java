package zerobase.weather.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "Diary", description = "Diary API")
public class DiaryController {
  private final DiaryService diaryService;

  @PostMapping("/create/diary")
  @Operation(summary = "create diary", description = "특정 날짜의 일기를 작성한다.")
  void createDiary(
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Schema(name = "date", description = "일기 생성 날짜", example = "2023-11-30")
    LocalDate date,

    @Schema(name = "text", description = "일기 내용", example = "오늘은 마라탕을 먹었다.")
    @RequestBody String text
  ) {
    diaryService.createDiary(date, text);
  }

  @GetMapping("/read/diary")
  @Operation(summary = "read diary", description = "특정 날짜의 일기를 조회한다.")
  List<Diary> readDiary(
    @Schema(name = "date", description = "일기 조회 날짜", example = "2023-11-30")
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
  ) {
    return diaryService.readDiary(date);
  }

  @GetMapping("/read/diaries")
  @Operation(summary = "read diaries", description = "특정 날짜 구간의 일기를 조회한다.")
  List<Diary> readDiaries(
    @Schema(name = "date", description = "일기 조회 시작 날짜 (언제 부터)", example = "2023-11-25")
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,

    @Schema(name = "date", description = "일기 조회 마지막 날짜 (언제 까지)", example = "2023-11-30")
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
  ) {
    return diaryService.readDiaries(startDate, endDate);
  }

  @PutMapping("/update/diary")
  @Operation(summary = "update diary", description = "특정 날짜의 일기를 수정한다.")
  void updateDiary(
    @Schema(name = "date", description = "일기 수정 날짜", example = "2023-11-30")
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,

    @Schema(name = "text", description = "일기 수정 내용", example = "오늘은 오전에 알바를 갔다.")
    @RequestBody String text
  ) {
    diaryService.updateDiary(date, text);
  }

  @DeleteMapping("/delete/diary")
  @Operation(summary = "delete diary", description = "특정 날짜의 일기를 모두 삭제한다.")
  void updateDiary(
    @Schema(name = "date", description = "일기 삭제 날짜", example = "2023-11-30")
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
  ) {
    diaryService.deleteDiary(date);
  }
}
