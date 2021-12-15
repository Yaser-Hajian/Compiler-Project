#!/bin/bash
# store paths in variables
testDir="./test"
testInputDir="$testDir/in"
testOutputDir="$testDir/out"
sourceDir="./src"
tablePath="$sourceDir/table.npt"
outputDir="./out"
dotClassFilesOutputDir="$outputDir/classes"
reportDir="$outputDir/report"
resultDir="$outputDir/result"

# make necessary directories if not existed before
mkdir -p $outputDir
mkdir -p $dotClassFilesOutputDir
mkdir -p $reportDir
mkdir -p $resultDir

# compile Main.java
javac -cp "$sourceDir" -d $dotClassFilesOutputDir $sourceDir/Main.java

# compare output result with expected result
inputFileNames=`ls $testInputDir`
for fileRelativePath in $inputFileNames; do
  currentfileName=${fileRelativePath%.*}
  testInputFile="$testInputDir/$currentfileName.cool"
  testOutputFile="$testOutputDir/$currentfileName.out"
  currentOutputFile="$resultDir/$currentfileName-result.out"
  reportFile="$reportDir/$currentfileName-report.txt"

  result=`java -cp "$dotClassFilesOutputDir" Main --input $testInputFile --output $currentOutputFile  --table $tablePath`

  if cmp -s "$testOutputFile" "$currentOutputFile"; then
    printf "Ok" > $reportFile
    printf "$currentfileName passed\n"
  else
    printf "%s" "$result" > $reportFile
    printf '%s failed. expected "%s" but result is "%s"\n' "$currentfileName" "`cat $testOutputFile`" "`cat $currentOutputFile`"
  fi
done


