#!/bin/bash

set -e

export DUBBO_IP_TO_REGISTRY=${MY_NODE_IP}
DUBBO_PORT_TO_REGISTRY=${REG_PORT}

echo "===========================================> ${MY_NODE_IP}"
echo "===========================================> ${DUBBO_IP_TO_REGISTRY}"

exec "$@"