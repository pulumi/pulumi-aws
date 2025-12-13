FROM jetpackio/devbox:latest@sha256:293d6d0a33205e88550198835e68bcff65a2e33d143857ad92c6c888e6a75ad7

# Installing your devbox project
WORKDIR /code
COPY devbox.json devbox.json
COPY devbox.lock devbox.lock
RUN sudo chown -R "${DEVBOX_USER}:${DEVBOX_USER}" /code


RUN devbox run -- echo "Installed Packages."

RUN devbox shellenv --init-hook >> ~/.profile
