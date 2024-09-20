{ pkgs, ... }: {
  channel = "stable-23.11";
  packages = [
    pkgs.openjdk11
  ];
  services.docker.enable = true;
  idx.extensions = [
    "Dart-Code.dart-code"
    "Dart-Code.flutter"
    "zhuangtongfa.material-theme"
    "LaurentTreguier.vscode-simple-icons"
    "circlecodesolution.ccs-flutter-color"
    "jeroen-meijer.pubspec-assist"
    "Nash.awesome-flutter-snippets"
    "robert-brunhage.flutter-riverpod-snippets"
    "AMiner.codegeex"
    "vscjava.vscode-java-pack"
    "redhat.java"
    "KylinIdeTeam.java"
    "formulahendry.code-runner"
  ];
  idx.previews = {
    enable = true;
    previews = { };
  };
  idx.workspace.onCreate = { };
}
