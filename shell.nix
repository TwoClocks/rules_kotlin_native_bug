    { pkgs ? import <nixpkgs> {} }:
    pkgs.mkShell {
      buildInputs = with pkgs; [
        bazel_7
        jdk23
        gcc
      ];
    }
