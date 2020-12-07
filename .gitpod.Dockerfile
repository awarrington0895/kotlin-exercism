FROM gitpod/workspace-full

# Install custom tools, runtimes, etc.
# For example "bastet", a command-line tetris clone:
# RUN brew install bastet
#
# More information: https://www.gitpod.io/docs/config-docker/
RUN sudo apt-get update \
    && sudo apt-get install -y curl
WORKDIR /workspace
RUN sudo curl -L -o exercism.tar.gz https://github.com/exercism/cli/releases/download/v3.0.13/exercism-3.0.13-linux-x86_64.tar.gz \
    && sudo tar -xzf exercism.tar.gz \
    && sudo mv exercism /usr/local/bin

RUN brew update
RUN brew install kotlin